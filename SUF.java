package p1;

/**
 * @author ivy
 *
 */
public class SUF {
	
	private int ai; //���
	private int sa; //��׺�����
	private int lcpa;  //����һ��suffǰ׼�ظ��ĳ���
	private int k;  //�ظ��ĳ���(���㣺����һ���ϵĳ��Ȳ�)
	private int r;  //�ظ��Ĵ�����һ
	private int p;  //�ظ���ʼ��λ������
	private String string; //��׺
	
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
	 * Ѱ��Lcpa���ظ�ǰ׺�ĳ���
	 * 
	 * @param pre ����һ����׺�ַ���
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
	 * Ѱ��K���ظ����еĳ��ȣ�����������׺�ַ����ĳ��Ȳ�
	 * 
	 * @param pre ����һ����׺�ַ���
	 * @return theLen
	 *
	 */
	public int findK(String pre) {
		int theLen=0;
		theLen=Math.abs(this.getString().length()-pre.length());
		
		return theLen;
	}
	
	/**
	 * Ѱ��R���ظ�������һ������ʼ��Ϊ0
	 * 
	 * @param pre ����һ����׺�ַ���
	 * @return theR
	 *
	 */
	public int findR() {
		int theR=0;
		theR=this.getLcpa()/this.getK();
		return theR;
	}
	
	/**
	 * Ѱ��P���ظ�������һ������ʼ��Ϊ0
	 * 
	 * @param pre ����һ��SA
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
