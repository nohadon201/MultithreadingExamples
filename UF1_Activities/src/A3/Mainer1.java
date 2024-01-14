package A3;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Mainer1 {
	public static void main(String[] args) {
		Note[] arpegio = 
			{
				new Note(Note.Frequency.C3, Note.Duration.semicorchea),
				new Note(Note.Frequency.D3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				new Note(Note.Frequency.G3, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.D4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),
				new Note(Note.Frequency.G4, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.D5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),
				new Note(Note.Frequency.G5, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.D6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),
				new Note(Note.Frequency.G6, Note.Duration.semicorchea),
				
				
				new Note(Note.Frequency.C7, Note.Duration.semicorchea),
				new Note(Note.Frequency.G6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),
				new Note(Note.Frequency.D6, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.G5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),
				new Note(Note.Frequency.D5, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.G4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),
				new Note(Note.Frequency.D4, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.G3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				new Note(Note.Frequency.D3, Note.Duration.semicorchea),
				
				
				new Note(Note.Frequency.A2, Note.Duration.semicorchea),
				new Note(Note.Frequency.B2, Note.Duration.semicorchea),
				new Note(Note.Frequency.C3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.A3, Note.Duration.semicorchea),
				new Note(Note.Frequency.B3, Note.Duration.semicorchea),
				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.A4, Note.Duration.semicorchea),
				new Note(Note.Frequency.B4, Note.Duration.semicorchea),
				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.A5, Note.Duration.semicorchea),
				new Note(Note.Frequency.B5, Note.Duration.semicorchea),
				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),
				
				
				new Note(Note.Frequency.A6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),
				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.B5, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.A5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),
				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.B4, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.A4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),
				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.B3, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.A3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				new Note(Note.Frequency.C3, Note.Duration.semicorchea),
				new Note(Note.Frequency.B2, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.C3, Note.Duration.semicorchea),
				new Note(Note.Frequency.D3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				new Note(Note.Frequency.G3, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.D4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),
				new Note(Note.Frequency.G4, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.D5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),
				new Note(Note.Frequency.G5, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.D6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),
				new Note(Note.Frequency.G6, Note.Duration.semicorchea),
				
				
				new Note(Note.Frequency.C7, Note.Duration.semicorchea),
				new Note(Note.Frequency.G6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),
				new Note(Note.Frequency.D6, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.G5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),
				new Note(Note.Frequency.D5, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.G4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),
				new Note(Note.Frequency.D4, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.G3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				new Note(Note.Frequency.D3, Note.Duration.semicorchea),
				
				
				new Note(Note.Frequency.A2, Note.Duration.semicorchea),
				new Note(Note.Frequency.B2, Note.Duration.semicorchea),
				new Note(Note.Frequency.C3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.A3, Note.Duration.semicorchea),
				new Note(Note.Frequency.B3, Note.Duration.semicorchea),
				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.A4, Note.Duration.semicorchea),
				new Note(Note.Frequency.B4, Note.Duration.semicorchea),
				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.A5, Note.Duration.semicorchea),
				new Note(Note.Frequency.B5, Note.Duration.semicorchea),
				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),
				
				
				new Note(Note.Frequency.A6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),
				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.B5, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.A5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),
				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.B4, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.A4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),
				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.B3, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.A3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				new Note(Note.Frequency.C3, Note.Duration.semicorchea),
				new Note(Note.Frequency.B2, Note.Duration.semicorchea),
			};
		
		Note[] piano =
			{
				//new Note(Note.Frequency.SILENCE, Note.Duration.redonda*12),
				
				
				new Note(Note.Frequency.C6, Note.Duration.redonda),
				
				
				new Note(Note.Frequency.B5, Note.Duration.blanca),
				
				new Note(Note.Frequency.D6, Note.Duration.blanca),
				
				/*1*/
				new Note(Note.Frequency.C6, Note.Duration.redonda),
				
				
				new Note(Note.Frequency.D6, Note.Duration.negra),
				
				new Note(Note.Frequency.C6, Note.Duration.negra),
				
				new Note(Note.Frequency.B5, Note.Duration.negra),
				
				new Note(Note.Frequency.D6, Note.Duration.negra),
				/*1end*/
				
				new Note(Note.Frequency.C6, Note.Duration.redonda),
				
				
				new Note(Note.Frequency.B5, Note.Duration.blanca),
				
				new Note(Note.Frequency.D6, Note.Duration.blanca),
				
				/*2*/
				new Note(Note.Frequency.D6, Note.Duration.corchea),
				new Note(Note.Frequency.E6, Note.Duration.corchea),
				
				new Note(Note.Frequency.C6, Note.Duration.blanca+Note.Duration.negra),
				
				
				new Note(Note.Frequency.E6, Note.Duration.negra),
				
				new Note(Note.Frequency.D6, Note.Duration.negra),
				
				new Note(Note.Frequency.C6, Note.Duration.negra),
				
				new Note(Note.Frequency.B5, Note.Duration.negra),
				/*2end*/
			};
		
		Note[] piano2 =
			{
				//new Note(Note.Frequency.SILENCE, Note.Duration.redonda*12),
				
				
				new Note(Note.Frequency.C5, Note.Duration.redonda),
				
				
				new Note(Note.Frequency.B4, Note.Duration.blanca),
				
				new Note(Note.Frequency.D5, Note.Duration.blanca),
				
				/*1*/
				new Note(Note.Frequency.C5, Note.Duration.redonda),
				
				
				new Note(Note.Frequency.F5, Note.Duration.negra),
				
				new Note(Note.Frequency.E5, Note.Duration.negra),
				
				new Note(Note.Frequency.D5, Note.Duration.negra),
				
				new Note(Note.Frequency.F5, Note.Duration.negra),
				/*1end*/
				
				new Note(Note.Frequency.C5, Note.Duration.redonda),
				
				
				new Note(Note.Frequency.B4, Note.Duration.blanca),
				
				new Note(Note.Frequency.D5, Note.Duration.blanca),
				
				/*2*/
				new Note(Note.Frequency.D5, Note.Duration.corchea),
				new Note(Note.Frequency.E5, Note.Duration.corchea),
				
				new Note(Note.Frequency.C5, Note.Duration.blanca+Note.Duration.negra),
				
				
				new Note(Note.Frequency.C6, Note.Duration.negra),
				
				new Note(Note.Frequency.B5, Note.Duration.negra),
				
				new Note(Note.Frequency.A5, Note.Duration.negra),
				
				new Note(Note.Frequency.G5, Note.Duration.negra),
				/*2end*/
			};
		
		Note[] piano3 =
			{
				//new Note(Note.Frequency.SILENCE, Note.Duration.redonda*12),
				
				
				new Note(Note.Frequency.E5, Note.Duration.redonda),
				
				
				new Note(Note.Frequency.D5, Note.Duration.blanca),
				
				new Note(Note.Frequency.F5, Note.Duration.blanca),
				
				/*1*/
				new Note(Note.Frequency.E5, Note.Duration.redonda),
				
				
				new Note(Note.Frequency.SILENCE, Note.Duration.redonda),
				/*1end*/
				
				new Note(Note.Frequency.E5, Note.Duration.redonda),
				
				
				new Note(Note.Frequency.D5, Note.Duration.blanca),
				
				new Note(Note.Frequency.F5, Note.Duration.blanca),
				
				/*2*/
				new Note(Note.Frequency.B5, Note.Duration.corchea),
				new Note(Note.Frequency.C6, Note.Duration.corchea),
				
				new Note(Note.Frequency.A5, Note.Duration.blanca+Note.Duration.negra),
				
				
				new Note(Note.Frequency.SILENCE, Note.Duration.redonda)
				/*2end*/
			};
		
		ExecutorService es = Executors.newCachedThreadPool();
		es.submit(new Performer(arpegio, 60, Note.Duration.negra));/**
		es.submit(new Performer(piano,60, Note.Duration.negra));
		es.submit(new Performer(piano2,60, Note.Duration.negra));
		es.submit(new Performer(piano3,60, Note.Duration.negra));**/
		es.shutdown();
	}
}
