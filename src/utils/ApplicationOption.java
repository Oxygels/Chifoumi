package utils;

public class ApplicationOption {

	private String pseudo = "PSEUDO";
	private int resolutionW = 1280;
	private int resolutionH = 720;
	private boolean isFullscreen = false;
	private BackgroundStyle bgStyle = BackgroundStyle.Zen;
	private FontStyle fontSize = FontStyle.Grand;
	private int maxWRound = 10;

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getResolutionW() {
		return resolutionW;
	}

	public void setResolutionW(int resolutionW) {
		this.resolutionW = resolutionW;
	}

	public boolean isFullscreen() {
		return isFullscreen;
	}

	public void setFullscreen(boolean isFullscreen) {
		this.isFullscreen = isFullscreen;
	}

	public BackgroundStyle getBgStyle() {
		return bgStyle;
	}

	public void setBgStyle(BackgroundStyle bgStyle) {
		this.bgStyle = bgStyle;
	}

	public FontStyle getFontSize() {
		return fontSize;
	}

	public void setFontSize(FontStyle fontSize) {
		this.fontSize = fontSize;
	}

	public int getMaxWRound() {
		return maxWRound;
	}

	public void setMaxWRound(int maxWRound) {
		this.maxWRound = maxWRound;
	}

	public int getResolutionH() {
		return resolutionH;
	}

	public void setResolutionH(int resolutionH) {
		this.resolutionH = resolutionH;
	}
}
