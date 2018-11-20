package mice.bean;

public class Image {
	String Image ;
	Goods goods;
	int id;
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
