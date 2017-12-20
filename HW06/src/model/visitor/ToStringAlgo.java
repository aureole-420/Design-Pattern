package model.visitor;

import provided.music.APhraseVisitor;
import provided.music.IPhrase;
import provided.music.NESeqList;
import provided.music.IPhraseVisitorCmd;
import provided.music.MTSeqList;

/**
 * The visitor algorithm that display the string expression of IPhrase object. 
 * @author Yuhui Tong, Yunxiang Zhang
 *
 */
public class ToStringAlgo extends APhraseVisitor {

	/**
	 * Constructor of To String algorithm
	 */
	public ToStringAlgo() {

		// non empty list case
		this.addCmd(NESeqList.ID, new IPhraseVisitorCmd() {
			/**
			 * {@inheritDoc}</br> 
			 * return the string expression of a non empty sequence list.
			 * params[0] is "{ _first" -- first item is specially treated.
			 */
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				// TODO Auto-generated method stub
				NESeqList list = (NESeqList) host;
				return list.getRest().execute(ToStringAlgo.this, params[0] + ", " + list.getFirst());
			}
		});

		// empty list case
		this.addCmd(MTSeqList.ID, new IPhraseVisitorCmd() {
			/**
			 * {@inheritDoc}</br> 
			 * return the string expression of an empty sequence list.
			 */
			@Override
			public Object apply(String id, IPhrase host, Object... params) {
				return params[0] + "}";
			}
		});
	}

}
