package mice.bean;

public class Image {
	String Image ;
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
	Goods goods;
	int id;
}
