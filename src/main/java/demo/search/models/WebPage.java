package demo.search.models;

import java.util.Arrays;
import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

public class WebPage {
	@Field
	private String id;

	@Field
	private String digest;
	@Field
	private float boost;

	@Field
	private String url;

	@Field
	private String content;
	@Field
	private String title;

	@Field
	private Date tstamp;

	@Field
	private String[] anchor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public float getBoost() {
		return boost;
	}

	public void setBoost(float boost) {
		this.boost = boost;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTstamp() {
		return tstamp;
	}

	public void setTstamp(Date tstamp) {
		this.tstamp = tstamp;
	}

	public String[] getAnchor() {
		return anchor;
	}

	public void setAnchor(String[] anchor) {
		this.anchor = anchor;
	}

	@Override
	public String toString() {
		return "WebPage [id=" + id + ", digest=" + digest + ", boost=" + boost
				+ ", url=" + url + ", content=" + content + ", title=" + title
				+ ", tstamp=" + tstamp + ", anchor=" + Arrays.toString(anchor)
				+ "]";
	}

}
