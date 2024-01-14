package A3;

public class Performer implements Runnable {
	Note[] notes;
	int tempo;
	public Performer(Note[] notes, int tempo, int nota) {
		this.notes=notes;
		this.tempo= (60000/tempo)/nota;
	}
	@Override
	public void run() {
		try
		{
			for(int i = 0; i < notes.length; i++)
			{
				MidiPlayer.setInstrument(MidiPlayer.getInstruments()[0],0);
				MidiPlayer.play(0, notes[i]);
				for(int a = 0; a < notes[i].getDuration(); a++) {
					Thread.sleep(tempo);
				}
				//MidiPlayer.play(1, notesRythm[i]);
				MidiPlayer.stop(0, notes[i]);
				//MidiPlayer.stop(1, notesRythm[i]);
			}
			
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
	
}
