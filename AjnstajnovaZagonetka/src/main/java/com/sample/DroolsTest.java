package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import java.util.LinkedList;
import java.util.List;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

	private static void izvrsiTest(Osoba o1, Osoba o2, Osoba o3, Osoba o4, Osoba o5) {
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
    	KieSession kSession = kContainer.newKieSession("ksession-rules");
    	
    	kSession.insert(o1);
    	kSession.insert(o2);
    	kSession.insert(o3);
    	kSession.insert(o4);
    	kSession.insert(o5);
    	
    	kSession.fireAllRules();
	}
	
	private static void ispisi(String delimiter, Osoba o1, Osoba o2, Osoba o3, Osoba o4, Osoba o5) {
		 System.out.println(delimiter);
         System.out.println(o1);
         System.out.println(o2);
         System.out.println(o3);
         System.out.println(o4);
         System.out.println(o5);
	}
	
	private static void iskalkulisi(String delimiter, Osoba o1, Osoba o2, Osoba o3, Osoba o4, Osoba o5) {
		izvrsiTest(o1, o2, o3, o4, o5);
        //ispisi(delimiter, o1, o2, o3, o4, o5);
	}
	
	private static void ukombinujJednu(Osoba o, Osoba b1, Osoba b2, Osoba b3, Osoba b4, Osoba b5) {
		if (o.isSlicna(b1)) {
			o.ukombinuj(b1);
		} 
		if (o.isSlicna(b2)) {
			o.ukombinuj(b2);
		} 
		if (o.isSlicna(b3)) {
			o.ukombinuj(b3);
		} 
		if (o.isSlicna(b4)) {
			o.ukombinuj(b4);
		} 
		if (o.isSlicna(b5)) {
			o.ukombinuj(b5);
		}
		
	}
	
	private static void ukombinuj(Osoba o1, Osoba o2, Osoba o3, Osoba o4, Osoba o5, Osoba b1, Osoba b2, Osoba b3, Osoba b4, Osoba b5) {
		ukombinujJednu(o1, b1,b2,b3,b4,b5);
		ukombinujJednu(o2, b1,b2,b3,b4,b5);
		ukombinujJednu(o3, b1,b2,b3,b4,b5);
		ukombinujJednu(o4, b1,b2,b3,b4,b5);
		ukombinujJednu(o5, b1,b2,b3,b4,b5);
		
		ukombinujJednu(b1, o1,o2,o3,o4,o5);
		ukombinujJednu(b2, o1,o2,o3,o4,o5);
		ukombinujJednu(b3, o1,o2,o3,o4,o5);
		ukombinujJednu(b4, o1,o2,o3,o4,o5);
		ukombinujJednu(b5, o1,o2,o3,o4,o5);
	}
	
	
	private static void ukombinujIteraciju(String iteracija, Osoba o1, Osoba o2, Osoba o3, Osoba o4, Osoba o5, Osoba or1, Osoba or2,
			Osoba or3, Osoba or4, Osoba or5, Osoba ob1, Osoba ob2, Osoba ob3, Osoba ob4, Osoba ob5, Osoba olj1,
			Osoba olj2, Osoba olj3, Osoba olj4, Osoba olj5, Osoba op1, Osoba op2, Osoba op3, Osoba op4, Osoba op5,
			Osoba oi1, Osoba oi2, Osoba oi3, Osoba oi4, Osoba oi5) {
		ukombinuj(o1, o2, o3, o4, o5, or1, or2, or3, or4, or5);
		ukombinuj(o1, o2, o3, o4, o5, ob1, ob2, ob3, ob4, ob5);
		ukombinuj(o1, o2, o3, o4, o5, olj1, olj2, olj3, olj4, olj5);
		ukombinuj(o1, o2, o3, o4, o5, oi1, oi2, oi3, oi4, oi5);
		ukombinuj(o1, o2, o3, o4, o5, op1, op2, op3, op4, op5);
		
		ukombinuj(or1, or2, or3, or4, or5, ob1, ob2, ob3, ob4, ob5);
		ukombinuj(or1, or2, or3, or4, or5, olj1, olj2, olj3, olj4, olj5);
		ukombinuj(or1, or2, or3, or4, or5, oi1, oi2, oi3, oi4, oi5);
		ukombinuj(or1, or2, or3, or4, or5, op1, op2, op3, op4, op5);
		
		ukombinuj(ob1, ob2, ob3, ob4, ob5, olj1, olj2, olj3, olj4, olj5);
		ukombinuj(ob1, ob2, ob3, ob4, ob5, oi1, oi2, oi3, oi4, oi5);
		ukombinuj(ob1, ob2, ob3, ob4, ob5, op1, op2, op3, op4, op5);
		
		ukombinuj(olj1, olj2, olj3, olj4, olj5, oi1, oi2, oi3, oi4, oi5);
		ukombinuj(olj1, olj2, olj3, olj4, olj5, op1, op2, op3, op4, op5);
		
		ukombinuj(oi1, oi2, oi3, oi4, oi5, op1, op2, op3, op4, op5);
		
		System.out.println(iteracija);
		iskalkulisi("Nacionalnost ", o1, o2, o3, o4, o5);
		iskalkulisi("Redosled ", or1, or2, or3, or4, or5);
		iskalkulisi("Boja ", ob1, ob2, ob3, ob4, ob5);
		iskalkulisi("Ljubimac ", olj1, olj2, olj3, olj4, olj5);
		iskalkulisi("Instrument ", oi1, oi2, oi3, oi4, oi5);
		iskalkulisi("Pice ", op1, op2, op3, op4, op5);
	}


    public static final void main(String[] args) {
        try {
        	Osoba o1, o2, o3, o4, o5;
        	Osoba or1, or2, or3, or4, or5;
        	Osoba ob1, ob2, ob3, ob4, ob5;
        	Osoba olj1, olj2, olj3, olj4, olj5;
        	Osoba op1, op2, op3, op4, op5;
        	Osoba oi1, oi2, oi3, oi4, oi5;
        	
            o1 = new Osoba();
            o1.nacionalnost = Nacionalnost.BRITANAC;
            o2 = new Osoba();
            o2.nacionalnost = Nacionalnost.DANAC;
            o3 = new Osoba();
            o3.nacionalnost = Nacionalnost.NEMAC;
            o4 = new Osoba();
            o4.nacionalnost = Nacionalnost.NORVEZANIN;
            o5 = new Osoba();
            o5.nacionalnost = Nacionalnost.SVEDJANIN;
            
            or1 = new Osoba();
            or1.redosledKuca = 1;
            or2 = new Osoba();
            or2.redosledKuca = 2;
            or3 = new Osoba();
            or3.redosledKuca = 3;
            or4 = new Osoba();
            or4.redosledKuca = 4;
            or5 = new Osoba();
            or5.redosledKuca = 5;
            
            ob1 = new Osoba();
            ob1.boja = Boja.BELA;
            ob2 = new Osoba();
            ob2.boja = Boja.CRVENA;
            ob3 = new Osoba();
            ob3.boja = Boja.PLAVA;
            ob4 = new Osoba();
            ob4.boja = Boja.ZELENA;
            ob5 = new Osoba();
            ob5.boja = Boja.ZUTA;
            
            olj1 = new Osoba();
            olj1.ljubimac = Ljubimac.KONJI;
            olj2 = new Osoba();
            olj2.ljubimac = Ljubimac.MACKA;
            olj3 = new Osoba();
            olj3.ljubimac = Ljubimac.PAS;
            olj4 = new Osoba();
            olj4.ljubimac = Ljubimac.PTICA;
            olj5 = new Osoba();
            olj5.ljubimac = Ljubimac.RIBICA;
            
            oi1 = new Osoba();
            oi1.instrument = Instrument.GITARA;
            oi2 = new Osoba();
            oi2.instrument = Instrument.HARMONIKA;
            oi3 = new Osoba();
            oi3.instrument = Instrument.KLAVIR;
            oi4 = new Osoba();
            oi4.instrument = Instrument.TRUBA;
            oi5 = new Osoba();
            oi5.instrument = Instrument.VIOLINA;
            
            op1 = new Osoba();
            op1.pice = Pice.CAJ;
            op2 = new Osoba();
            op2.pice = Pice.KAFA;
            op3 = new Osoba();
            op3.pice = Pice.MLEKO;
            op4 = new Osoba();
            op4.pice = Pice.PIVO;
            op5 = new Osoba();
            op5.pice = Pice.VODA;
            
        	
        	iskalkulisi("Nacionalnost 1", o1, o2, o3, o4, o5);
        	iskalkulisi("Redosled 1", or1, or2, or3, or4, or5);
        	iskalkulisi("Boja 1", ob1, ob2, ob3, ob4, ob5);
        	iskalkulisi("Ljubimac 1", olj1, olj2, olj3, olj4, olj5);
        	iskalkulisi("Instrument 1", oi1, oi2, oi3, oi4, oi5);
        	iskalkulisi("Pice 1", op1, op2, op3, op4, op5);
        	
        	
        	
        	
        	
        	
        	ukombinujIteraciju("2ga iteracija",o1, o2, o3, o4, o5, or1, or2, or3, or4, or5, ob1, ob2, ob3, ob4, ob5, olj1, olj2, olj3,
					olj4, olj5, op1, op2, op3, op4, op5, oi1, oi2, oi3, oi4, oi5);
        	
        	ukombinujIteraciju("3ca iteracija",o1, o2, o3, o4, o5, or1, or2, or3, or4, or5, ob1, ob2, ob3, ob4, ob5, olj1, olj2, olj3,
					olj4, olj5, op1, op2, op3, op4, op5, oi1, oi2, oi3, oi4, oi5);
        	
        	ukombinujIteraciju("4ta iteracija",o1, o2, o3, o4, o5, or1, or2, or3, or4, or5, ob1, ob2, ob3, ob4, ob5, olj1, olj2, olj3,
					olj4, olj5, op1, op2, op3, op4, op5, oi1, oi2, oi3, oi4, oi5);

        	ukombinujIteraciju("5ta iteracija",o1, o2, o3, o4, o5, or1, or2, or3, or4, or5, ob1, ob2, ob3, ob4, ob5, olj1, olj2, olj3,
					olj4, olj5, op1, op2, op3, op4, op5, oi1, oi2, oi3, oi4, oi5);
        	
        	ukombinujIteraciju("6ta iteracija",o1, o2, o3, o4, o5, or1, or2, or3, or4, or5, ob1, ob2, ob3, ob4, ob5, olj1, olj2, olj3,
					olj4, olj5, op1, op2, op3, op4, op5, oi1, oi2, oi3, oi4, oi5);
        	
        	ukombinujIteraciju("7ma iteracija",o1, o2, o3, o4, o5, or1, or2, or3, or4, or5, ob1, ob2, ob3, ob4, ob5, olj1, olj2, olj3,
					olj4, olj5, op1, op2, op3, op4, op5, oi1, oi2, oi3, oi4, oi5);
        	
        	ukombinujIteraciju("8ma iteracija",o1, o2, o3, o4, o5, or1, or2, or3, or4, or5, ob1, ob2, ob3, ob4, ob5, olj1, olj2, olj3,
					olj4, olj5, op1, op2, op3, op4, op5, oi1, oi2, oi3, oi4, oi5);
        	
        	ukombinujIteraciju("9ta iteracija",o1, o2, o3, o4, o5, or1, or2, or3, or4, or5, ob1, ob2, ob3, ob4, ob5, olj1, olj2, olj3,
					olj4, olj5, op1, op2, op3, op4, op5, oi1, oi2, oi3, oi4, oi5);
        	
        	ukombinujIteraciju("10ta iteracija",o1, o2, o3, o4, o5, or1, or2, or3, or4, or5, ob1, ob2, ob3, ob4, ob5, olj1, olj2, olj3,
					olj4, olj5, op1, op2, op3, op4, op5, oi1, oi2, oi3, oi4, oi5);
        	
        	
        	
        	ispisi("Nacionalnost ", o1, o2, o3, o4, o5);
        	ispisi("Redosled ", or1, or2, or3, or4, or5);
        	ispisi("Boja ", ob1, ob2, ob3, ob4, ob5);
        	ispisi("Ljubimac ", olj1, olj2, olj3, olj4, olj5);
        	ispisi("Instrument ", oi1, oi2, oi3, oi4, oi5);
        	ispisi("Pice ", op1, op2, op3, op4, op5);

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

	

    

}
