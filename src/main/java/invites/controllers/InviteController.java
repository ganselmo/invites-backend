package invites.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import invites.entities.Invite;
import invites.services.InviteService;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/invites")

public class InviteController {

	private static Logger LOG = LoggerFactory.getLogger(InviteController.class);

	@Autowired
	private InviteService inviteService;
	
	@GetMapping("")
	public List<Invite> getAll() {
		return this.inviteService.getInvites();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Invite> getInvite(@PathVariable("id") int id) {
		LOG.info("Buscando Invite {}", id);
		Optional<Invite> invite = this.inviteService.getInvite(id);

		if (!invite.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Invite>(invite.get(), HttpStatus.OK);
		}
	}

	@PostMapping("")
	public ResponseEntity<?> addInvite(@RequestBody List<Invite>invites) {
		
		LOG.info(invites.get(0).getName());
		boolean ok = this.inviteService.addInvites(invites);
		if (!ok) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<>( HttpStatus.OK);
		}
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteInvite(@PathVariable("id") int id) {
		boolean ok = this.inviteService.deleteInvite(id);
		if (!ok) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<>(id, HttpStatus.OK);
		}
	}

	


}

