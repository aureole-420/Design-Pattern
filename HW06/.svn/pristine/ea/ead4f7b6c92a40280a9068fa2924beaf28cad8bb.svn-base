package model;

import java.util.ArrayDeque;
import java.util.Deque;

import model.visitor.PlayMusicAlgo;
import model.visitor.ToStringAlgo;
import provided.abcParser.ABCParser;
import provided.music.APhraseVisitor;
import provided.music.IPhrase;
import provided.music.IPhraseVisitor;
import provided.music.Note;
import provided.player.ISequencePlayerStatus;
import provided.player.SequencePlayer;
import provided.music.IPhraseVisitorCmd;
import provided.music.NESeqList;
import provided.util.ABCInstrument;
import provided.util.ABCUtil;

/**
 * The model of ABCMusicPlayer
 * @author Yuhui Tong, Yunxiang Zhang
 *
 */
public class ABCPlayerModel {

	/**
	 * ABCParser to parse the .abc file into an IPhrase structure.
	 */
	private ABCParser _parser;

	/**
	 * The IPhrase structure.
	 */
	private IPhrase _musicPhrase;

	/**
	 * The sequence player to create and play MIDI music sequence.
	 */
	private Deque<SequencePlayer> _players;

	/**
	 * The model to view adapter.
	 */
	private IModel2ViewAdapter _model2ViewAdpt;

	/**
	 * Constructor of ABCMusicPlayerModel
	 */
	public ABCPlayerModel(IModel2ViewAdapter _adapter) {
		_players = new ArrayDeque<SequencePlayer>();
		this._model2ViewAdpt = _adapter;
		NESeqList.setToStringAlgo(new ToStringAlgo());
	}

	/**
	 * This method tells model to load a music of filename.
	 */
	public void loadABCFile(String filename) {
		_model2ViewAdpt.displayFileContent(ABCUtil.Singleton.getFileContents(fixPath(filename)));
		_parser = new ABCParser(fixPath(filename));
		_musicPhrase = _parser.parse();
	}

	private String fixPath(String filename) {
		return "/songs/" + filename + ".abc";
	}

	/**
	 * This method tells model to parse an .abc file.
	 * @return The string expression of IPhrase structure.
	 */
	public String parseFile() {
		return _musicPhrase.toString();
	}

	/**
	 * This method tells model to play the 
	 * @param instrument The instrument that music is played with
	 */
	public void play(ABCInstrument instrument) {
		SequencePlayer _player = new SequencePlayer(16, instrument.getValue());
		_players.push(_player);
		_player.setTempo(140);
		_musicPhrase.execute(new PlayMusicAlgo(), _player, 0);
		_player.play(ISequencePlayerStatus.NULL);
	}

	/**
	 * stop sequenceplayer from playing music, one sequence player at a time.
	 */
	public void stop() {
		if (!_players.isEmpty()) {
			SequencePlayer _player = _players.pop();
			_player.stop();
		}
	}

	/**
	 * Start playing music
	 */
	public void start() {
		// do nothing.
	}

	/**
	 * add Instrument to view's droplist.
	 */
	public void addInstruments2View() {
		ABCInstrument[] instruments = ABCUtil.Singleton.getInstruments();
		for (ABCInstrument instrument : instruments) {
			_model2ViewAdpt.addInstrument(instrument);
		}
	}

	/**
	 * Testing client
	 * @param args default argument
	 */
	public static void main(String[] args) {

		/**
		SequencePlayer sp = new SequencePlayer(16, 1);
		sp.setTicksPerDefaultNote(16);
		sp.setTempo(140);
		Note g = new Note('G', 0, 0, 1.0, false);
		int newStart = sp.addNote(g, 10);
		sp.addNote(new Note('B', 0, 0, 1.0, false), 10);
		//newStart = sp.addNote(new Note('B', 0, 0, 1.0, false), newStart);
		//newStart = sp.addNote(new Note('C', 0, 0, 1.0, false), newStart);
		//newStart = sp.addNote(new Note('D', 0, 0, 1.0, false), newStart);
		//newStart = sp.addNote(new Note('E', 0, 0, 1.0, false), newStart);
		//newStart = sp.addNote(new Note('F', 0, 0, 1.0, false), newStart);
		//newStart = sp.addNote(new Note('G', 0, 0, 1.0, false), newStart);
		sp.play(ISequencePlayerStatus.NULL);
		*/

		SequencePlayer sp = new SequencePlayer(16, 1);
		sp.setTicksPerDefaultNote(16);
		sp.setTempo(140);
		IPhrase note = new Note('D', 0, 0, 1.0, false);
		IPhraseVisitor v = new APhraseVisitor() {
			{
				addCmd(Note.ID, new IPhraseVisitorCmd() {

					@Override
					public Object apply(String id, IPhrase host, Object... params) {
						SequencePlayer player = (SequencePlayer) params[0];
						Note nt = (Note) host;
						return player.addNote(nt, (int) params[1]);
					}

				});
			}
		};
		note.execute(v, sp, 10);
		sp.play(ISequencePlayerStatus.NULL);

		ABCParser parser = new ABCParser("/songs/scale.abc");
		IPhrase testphrase = parser.parse();
		ToStringAlgo tsa = new ToStringAlgo();
		NESeqList list = (NESeqList) testphrase;
		NESeqList.setToStringAlgo(tsa);
		System.out.println(testphrase.execute(tsa, "{"));
		System.out.println(list.toString());
		System.out.println(testphrase.toString());
	}
}
