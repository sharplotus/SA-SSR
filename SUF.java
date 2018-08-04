package p1;

/**
 * @author ivy
 *
 */
public class SUF {
	
	private int ai; //编号
	private int sa; //后缀树编号
	private int lcpa;  //与上一个suff前准重复的长度
	private int k;  //重复的长度(计算：与上一个上的长度差)
	private int r;  //重复的次数减一
	private int p;  //重复开始的位置索引
	private String string; //后缀
	
	public SUF() {
		this.ai=-1;
		this.sa=-1;
		this.lcpa=-1;
		this.k=-1;
		this.r=0;
		this.p=-1;
		this.string="null";
	}
	
	public SUF(int ai,int sa,int lcpa,int k,int r,int p,String string) {
		this.ai=ai;
		this.sa=sa;
		this.lcpa=lcpa;
		this.k=k;
		this.r=r;
		this.p=p;
		this.string=string;
	}
	
	/**
	 * 寻找Lcpa，重复前缀的长度
	 * 
	 * @param pre 是上一个后缀字符串
	 * @return same
	 *
	 */
	public int findLcpa(String pre) {
		int same=0;
		char[] preC=pre.toCharArray();
		char[] currC=this.getString().toCharArray();
		for(int i=0;i<pre.length();i++) {
			if(preC[i]==currC[i]) {
				same++;
			}else {
				break;
			}
		}
		return same;
	}
	
	/**
	 * 寻找K，重复序列的长度，计算两个后缀字符串的长度差
	 * 
	 * @param pre 是上一个后缀字符串
	 * @return theLen
	 *
	 */
	public int findK(String pre) {
		int theLen=0;
		theLen=Math.abs(this.getString().length()-pre.length());
		
		return theLen;
	}
	
	/**
	 * 寻找R，重复次数减一，被初始化为0
	 * 
	 * @param pre 是上一个后缀字符串
	 * @return theR
	 *
	 */
	public int findR() {
		int theR=0;
		theR=this.getLcpa()/this.getK();
		return theR;
	}
	
	/**
	 * 寻找P，重复次数减一，被初始化为0
	 * 
	 * @param pre 是上一个SA
	 * @return theR
	 *
	 */
	public int findP(int pre) {
		if(pre<=this.sa) {
			return pre;
		}else {
			return this.sa;
		}
	}
	
	
	/**
	 * auto get and set
	 *
	 */
	public int getAi() {
		return ai;
	}

	public void setAi(int ai) {
		this.ai = ai;
	}

	public int getSa() {
		return sa;
	}

	public void setSa(int sa) {
		this.sa = sa;
	}

	public int getLcpa() {
		return lcpa;
	}

	public void setLcpa(int lacpa) {
		this.lcpa = lacpa;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
	
}
