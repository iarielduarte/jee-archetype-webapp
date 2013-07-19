package ar.com.jee.beans;

import javax.ejb.Stateless;

@Stateless
public class SampleEJB {

	public int sumar(int a, int b){
		return a+b;
	}
}
