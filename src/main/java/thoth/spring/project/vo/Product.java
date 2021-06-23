package thoth.spring.project.vo;

public class Product {

    protected String tnum;
    protected String title;
    protected String author;
    protected String publish;
    protected String image;
    protected int origin_price;
    protected int sale_price;
    protected int amount;

    // join 사용을 위해 추가
    protected String fnames;
    protected String fsizes;
    protected String uuid;

    public String getTnum() {
        return tnum;
    }

    public void setTnum(String tnum) {
        this.tnum = tnum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getOrigin_price() {
        return origin_price;
    }

    public void setOrigin_price(int origin_price) {
        this.origin_price = origin_price;
    }

    public int getSale_price() {
        return sale_price;
    }

    public void setSale_price(int sale_price) {
        this.sale_price = sale_price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    // 나중에 맞는지 확인해 볼것
    public String getFnames() {
        return fnames;
    }

    public void setFnames(String fnames) {
        this.fnames = fnames;
    }

    public String getFsizes() {
        return fsizes;
    }

    public void setFsizes(String fsizes) {
        this.fsizes = fsizes;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
