package com.sample;

public class Osoba {
	public Nacionalnost nacionalnost = Nacionalnost.NOT_SELECTED;
	
	public Pice pice = Pice.NOT_SELECTED;
	
	public Ljubimac ljubimac = Ljubimac.NOT_SELECTED;
	
	public Boja boja = Boja.NOT_SELECTED;
	
	public int redosledKuca = 0;
	
	public int getRedosledKuca() {
		return redosledKuca;
	}

	public void setRedosledKuca(int red) {
		redosledKuca = red;
	}

	public Nacionalnost getNacionalnost() {
		return nacionalnost;
	}

	public void setNacionalnost(Nacionalnost nacionalnost) {
		this.nacionalnost = nacionalnost;
	}

	public Pice getPice() {
		return pice;
	}

	public void setPice(Pice pice) {
		this.pice = pice;
	}

	public Ljubimac getLjubimac() {
		return ljubimac;
	}

	public void setLjubimac(Ljubimac ljubimac) {
		this.ljubimac = ljubimac;
	}

	public Boja getBoja() {
		return boja;
	}

	public void setBoja(Boja boja) {
		this.boja = boja;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public Instrument instrument = Instrument.NOT_SELECTED;
	
	public String toString(){
		return redosledKuca +"\t"+nacionalnost+"\tljubimac: "+ljubimac+"\tinstrument: "+instrument + "\tboja: "+ boja + "\tpice " + pice;
	}
	
	public boolean isSlicna(Osoba o) {
		boolean out=  ((o.boja == this.boja && this.boja != Boja.NOT_SELECTED)  || 
				(o.instrument == this.instrument && this.instrument != Instrument.NOT_SELECTED )  || 
				(o.ljubimac == this.ljubimac && this.ljubimac != Ljubimac.NOT_SELECTED) ||
				(o.nacionalnost == this.nacionalnost && this.nacionalnost != Nacionalnost.NOT_SELECTED) || 
				(o.pice == this.pice && this.pice != Pice.NOT_SELECTED)||
				(o.redosledKuca == this.redosledKuca && this.redosledKuca != 0));
			//System.out.println(out + "\t " +this +" " + o + " " );
		return out;
	}
	
	public void ukombinuj(Osoba o) {
		if (o.boja != Boja.NOT_SELECTED) this.boja = o.boja;
		if (o.instrument !=  Instrument.NOT_SELECTED) this.instrument = o.instrument;
		if (o.ljubimac != Ljubimac.NOT_SELECTED) this.ljubimac = o.ljubimac;
		if (o.nacionalnost != Nacionalnost.NOT_SELECTED) this.nacionalnost = o.nacionalnost;
		if (o.pice != Pice.NOT_SELECTED) this.pice = o.pice;
		if (o.redosledKuca != 0 ) this.redosledKuca = o.redosledKuca;
		
	}
	
}
