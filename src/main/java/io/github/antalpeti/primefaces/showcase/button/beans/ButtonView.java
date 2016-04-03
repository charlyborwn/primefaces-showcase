package io.github.antalpeti.primefaces.showcase.button.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "buttonButtonView")
public class ButtonView {

  public void buttonAction(ActionEvent actionEvent) {
    addMessage("Welcome to Primefaces!!");
  }

  public void addMessage(String summary) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
    FacesContext.getCurrentInstance().addMessage(null, message);
  }
}
