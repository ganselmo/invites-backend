package invites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import invites.entities.Invite;

@Repository
public interface InviteRepository extends JpaRepository<Invite,Integer> {

}
