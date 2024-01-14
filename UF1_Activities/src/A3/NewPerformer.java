package A3;

import javax.sound.midi.Instrument;

public class NewPerformer implements Runnable {
	Note[] notes;
	Conductor conductor;
	public static int chan=-1;
	public NewPerformer(Note[] notes, Conductor c, Instrument i) {
		this.notes=notes;
		this.conductor=c;
		chan++;
		System.out.println("this channel: "+this.chan);
		MidiPlayer.setInstrument(i,chan);
	}
	@Override
	public void run() {
		try
		{
			for(int i = 0; i < notes.length; i++)
			{				
				MidiPlayer.play(chan, notes[i]);
				for(int a = 0; a < notes[i].getDuration(); a++) {
					synchronized (conductor) {
						conductor.wait();
					} 
				}
				MidiPlayer.stop(chan, notes[i]);
			}
			
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
