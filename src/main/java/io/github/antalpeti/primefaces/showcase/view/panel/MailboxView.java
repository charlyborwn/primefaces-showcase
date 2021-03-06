package io.github.antalpeti.primefaces.showcase.view.panel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import io.github.antalpeti.primefaces.showcase.domain.Mail;

@ManagedBean(name = "mailboxView")
@ViewScoped
public class MailboxView implements Serializable {

  private TreeNode mailboxes;

  private List<Mail> mails;

  private Mail mail;

  private TreeNode mailbox;

  @PostConstruct
  public void init() {
    mailboxes = new DefaultTreeNode("root", null);

    TreeNode inbox = new DefaultTreeNode("i", "Inbox", mailboxes);
    TreeNode sent = new DefaultTreeNode("s", "Sent", mailboxes);
    TreeNode trash = new DefaultTreeNode("t", "Trash", mailboxes);
    TreeNode junk = new DefaultTreeNode("j", "Junk", mailboxes);

    TreeNode gmail = new DefaultTreeNode("Gmail", inbox);
    TreeNode hotmail = new DefaultTreeNode("Hotmail", inbox);

    mails = new ArrayList<Mail>();
    mails.add(new Mail("optimus@primefaces.com", "Team Meeting", "Meeting to discuss roadmap",
        new Date()));
    mails.add(new Mail("spammer@spammer.com", "You've won Lottery",
        "Send me your credit card info to claim", new Date()));
    mails.add(new Mail("spammer@spammer.com", "Your email has won", "Click the exe file to claim",
        new Date()));
    mails.add(new Mail("primefaces-commits", "[primefaces] r4491 - Layout mailbox sample",
        "Revision:4490 Author:cagatay.civici", new Date()));
  }

  public TreeNode getMailboxes() {
    return mailboxes;
  }

  public List<Mail> getMails() {
    return mails;
  }

  public Mail getMail() {
    return mail;
  }

  public void setMail(Mail mail) {
    this.mail = mail;
  }

  public TreeNode getMailbox() {
    return mailbox;
  }

  public void setMailbox(TreeNode mailbox) {
    this.mailbox = mailbox;
  }

  public void send() {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mail Sent!"));
  }
}
