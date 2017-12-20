package view;

/**
 * The view to model adapter that allows view to talk to model (to use model's methods).
 * @author Yuhui Tong, Yunxiang Zhang	
 *
 */
public interface IView2ModelAdapter<TInstrument> {

	/**
	 * This method tells model to add instruments to view's instrument drop list.
	 */
	public void addInstruments();

	/**
	 * This method tells model to load a music of filename.
	 * @param filename The filename of the the music to be played.
	 */
	public void load(String filename);

	/**
	 * This method tells model to parse an .abc file.
	 * @return The string expression of IPhrase structure.
	 */
	public String parse();

	/**
	 * This method tells model to play the music
	 * @param instrument The Instrument to play with
	 */
	public void play(TInstrument instrument);

	/**
	 * This method tells model to stop playing music.
	 */
	public void stop();

}
