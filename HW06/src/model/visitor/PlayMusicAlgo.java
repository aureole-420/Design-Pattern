package model.visitor;

import provided.music.APhraseVisitor;
import provided.music.Chord;
import provided.music.Header;
import provided.music.IPhrase;
import provided.music.IPhraseVisitorCmd;
import provided.music.MTSeqList;
import provided.music.NESeqList;
import provided.music.Note;
import provided.music.Triplet;
import provided.player.SequencePlayer;
import provided.util.ABCUtil;
import provided.util.KeySignature;

/**
 * The parsed IPhrase object (host) delegates the processing of subpieces of a music to this algorithm.
 * Will be called by the host, and add the appropriate notes to the sequence plaer so that music
 * can be played.
 * @author Yuhui Tong, Yunxiang Zhang
 *
 */
public class PlayMusicAlgo extends APhraseVisitor {
	/**
	 * The key signature. 
	 * Used to tune notes.
	 */
	private KeySignature _keySignature = null;

	/**
	 * Constructor of PlayMusicAlgo
	 */
	public PlayMusicAlgo() {

		super(new IPhraseVisitorCmd() { // defaultCmd for unknown host.
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				return params[1]; //return current tick
			}
		});

		// deal with ignored headers.
		String headerString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < headerString.length(); i++) {
			this.addCmd("" + headerString.charAt(i), new IPhraseVisitorCmd() {
				/**
				 * {@inheritDoc}</br>
				 * params[0] player
				 * params[1] tick
				 */
				@Override
				public Object apply(String id, IPhrase host, Object... params) {
					return params[1]; // return current tick
				}
			});
		}

		// dealing with empty sequence list.
		this.addCmd(MTSeqList.ID, new IPhraseVisitorCmd() {
			/**
			 * {@inheritDoc}</br>
			 * params[0] player
			 * params[1] tick
			 */
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				return params[1]; // return tick.
			}
		});

		// dealing with nonempty sequence list.
		this.addCmd(NESeqList.ID, new IPhraseVisitorCmd() {
			/**
			 * {@inheritDoc}</br>
			 * params[0] player
			 * params[1] tick
			 */
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				NESeqList list = (NESeqList) host;
				Object stopTick = list.getFirst().execute(PlayMusicAlgo.this, params);
				return list.getRest().execute(PlayMusicAlgo.this, params[0], stopTick);
			}
		});

		// dealing with Note.
		this.addCmd(Note.ID, new IPhraseVisitorCmd() {
			/**
			 * {@inheritDoc}</br>
			 * params[0] player
			 * params[1] tick
			 */
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				// params[0] player
				// params[1] tick
				SequencePlayer player = (SequencePlayer) params[0];
				Note newNote = _keySignature.adjust((Note) host);
				return player.addNote(newNote, (int) params[1]); // return 
			}
		});

		// dealing with Chord (a collection of notes).
		this.addCmd(Chord.ID, new IPhraseVisitorCmd() {
			/**
			 * {@inheritDoc}</br>
			 * params[0] player
			 * params[1] tick
			 */
			@Override
			public Object apply(String id, IPhrase host, Object... params) {

				Note[] notes = ((Chord) host).getNotes();
				Object stopTick = params[1];
				for (Note note : notes) {
					// all notes played at the same time.
					stopTick = note.execute(PlayMusicAlgo.this, params);
				}
				return stopTick;
			}
		});

		// deadling with Triplet (a collection of notes played in a sequence with 2/3 duration).
		this.addCmd(Triplet.ID, new IPhraseVisitorCmd() {
			/**
			 * {@inheritDoc}</br>
			 * params[0] player
			 * params[1] tick
			 */
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				// params[0] player
				// params[1] tick
				// SequencePlayer player = (SequencePlayer) params[0];
				Note[] notes = ((Triplet) host).getNotes();
				Object stopTick = params[1]; //
				for (Note note : notes) {
					note.setDuration(note.getDuration() * (2.0 / 3));
					stopTick = note.execute(PlayMusicAlgo.this, params[0], stopTick);//update stoptick
				}
				return stopTick;
			}
		});

		// dealing with KeySignature.
		this.addCmd("K", new IPhraseVisitorCmd() {
			/**
			 * {@inheritDoc}</br>
			 * params[0] player
			 * params[1] tick
			 */
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				_keySignature = new KeySignature(((Header) host).getValue());
				return params[1];// return the tick;
			}
		});

		// dealing with tempo
		this.addCmd("Q", new IPhraseVisitorCmd() {
			/**
			 * {@inheritDoc}</br>
			 * params[0] player
			 * params[1] tick
			 */
			@Override
			public Object apply(String id, IPhrase host, Object... params) {

				System.out.println(params[1]);
				SequencePlayer player = (SequencePlayer) params[0];
				double defaultNotesPerQuarterNote = player.getTicksPerQuarterNote() / player.getTicksPerDefaultNote();
				int bpm = (int) ABCUtil.Singleton.parseTempo(((Header) host).getValue(), defaultNotesPerQuarterNote);
				//System.out.println("bpm: " + bpm);
				player.setTempo(bpm);
				return params[1];
			}
		});

		// dealing with Default Note
		this.addCmd("L", new IPhraseVisitorCmd() {
			/**
			 * {@inheritDoc}</br>
			 * params[0] player
			 * params[1] tick
			 */
			@Override
			public Object apply(String id, IPhrase host, Object... params) {

				double frac = ABCUtil.Singleton.parseFraction(((Header) host).getValue());
				SequencePlayer player = (SequencePlayer) params[0];
				frac = frac * player.getTicksPerQuarterNote() * 4;
				player.setTicksPerDefaultNote((int) frac);
				// System.out.println("bpm:" + player.getTempo());
				return params[1];
			}
		});

	}

}
