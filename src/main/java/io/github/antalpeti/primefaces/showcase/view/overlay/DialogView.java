package io.github.antalpeti.primefaces.showcase.view.overlay;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "dialogView")
public class DialogView {

  public void destroyWorld() {
    addMessage("System Error", "Please try again later.");
  }

  public void addMessage(String summary, String detail) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
    FacesContext.getCurrentInstance().addMessage(null, message);
  }
}
