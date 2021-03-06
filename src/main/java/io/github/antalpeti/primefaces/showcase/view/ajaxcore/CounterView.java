package io.github.antalpeti.primefaces.showcase.view.ajaxcore;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="ajaxcoreCounterView")
@ViewScoped
public class CounterView implements Serializable {
     
	private static final long serialVersionUID = -3263329010974817455L;
	
	private int number;
 
    public int getNumber() {
        return number;
    }
 
	public void increment() {
        number++;
    }
}