package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AffectationProject;
import com.example.demo.entities.Ticket;
import com.example.demo.entities.Users;

@Service
public class NotificationMail {


private JavaMailSender javaMailSender;

@Autowired
public NotificationMail(JavaMailSender javaMailSender) {
	super();
	this.javaMailSender = javaMailSender;
} 


public void sendMail(Users user) throws MailException {
	SimpleMailMessage mail = new SimpleMailMessage();
	mail.setText(user.getUsername());
	mail.setTo(user.getUsername());
	mail.setFrom("suptechmiage2018@gmail.com");
	mail.setSubject("BIENVENUE");
	mail.setText("Bienvenue à POWER  Mr/Mme " +user.getLastName()+ " Nous sommes heureux "
			+ "de vous compter parmis nos colaborateurs . Voici votre mot de passe :" +user.getPassword()+ ".  Vous "
					+ "  pouvez le changer à tout moment dans l'onglet Profile ");
	
	javaMailSender.send(mail);
}






public void resetPassword(Users user) throws MailException {
	SimpleMailMessage mail = new SimpleMailMessage();
	mail.setText(user.getUsername());
	mail.setTo(user.getUsername());
	mail.setFrom("suptechmiage2018@gmail.com");
	mail.setSubject("Reset PAssword");
	mail.setText("Bonjour  Mr/Mme " +user.getLastName()+ " . Votre nouveau mot de passe est : " +user.getPassword());
	
	javaMailSender.send(mail);
}

public void notifTicket(Ticket ticket) throws MailException {
	SimpleMailMessage mail = new SimpleMailMessage();
	mail.setTo(ticket.getUser().getUsername());
	mail.setFrom("suptechmiage2018@gmail.com");
	mail.setSubject("New Ticket");
	mail.setText("Bonjour  Mr/Mme "  + ticket.getUser().getLastName()+ " " + ticket.getUser().getFirstName() +
			" Vous avez affecté à un nouveau Ticket de priorité" + ticket.getPriorityTicket() + ", concernant le client "+ 
			ticket.getCustomer().getName()+".");
	
	javaMailSender.send(mail);
}

public void notifTaskProject(Users u , AffectationProject afp) throws MailException {
	//for (Users u : users) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(u.getUsername());
		mail.setFrom("suptechmiage2018@gmail.com");
		mail.setSubject("New Ticket");
		mail.setText("Bonjour  Mr/Mme "  + u.getLastName()+ " " + u.getFirstName() +
				" Vous avez affecté à une nouvelle tache de : " + afp.getProjATsk().getNameProjectTask() + ", concernant le projet  "+ 
				afp.getProject().getName()+".");
		
		javaMailSender.send(mail);
	//}
	
}

}