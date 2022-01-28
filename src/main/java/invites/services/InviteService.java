package invites.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import invites.entities.Invite;
import invites.repositories.InviteRepository;

@Service
public class InviteService {
	
	@Autowired
	private InviteRepository inviteRepository;
	
	public List<Invite> getInvites() {
		return this.inviteRepository.findAll();
	}
	
	public Optional<Invite> getInvite(int id) {
		return this.inviteRepository.findById(id);
	}

	@Transactional
	public Boolean addInvites(List<Invite> invites) {
		
		for (Invite invite : invites) {
			this.inviteRepository.save(invite);
			if (this.getInvite(invite.getId()) == null) {
				return false;
			}
		}
		return true;
		
	}

	@Transactional
	public Boolean deleteInvite(int id) {
		this.inviteRepository.deleteById(id);
		if(!this.getInvite(id).isPresent()) {
			return true;
		} else {
			return false;
		}
	}
}
