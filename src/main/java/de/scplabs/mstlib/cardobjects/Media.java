package de.scplabs.mstlib.cardobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a media element in an adaptive card, allowing the inclusion of audio or video content
 * with multiple sources, poster image, alternative text, and caption sources.
 *
 * @param <T> the parent type
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Media<T extends CardParent<?>> extends CardSetObject<T, Media<T>> {

    @JsonProperty(required = true)
    private final List<MediaSource> sources = new ArrayList<>();
    private String poster = "";
    private String altText = "";
    private final List<CaptionSource> captionSources = new ArrayList<>();

    public List<MediaSource> getSources() { return sources; }
    public String getPoster() { return poster; }
    public String getAltText() { return altText; }
    public List<CaptionSource> getCaptionSources() { return captionSources; }

    /**
     * Protected default constructor for serialization.
     */
    protected Media() {
        super(null, null);
    }

    /**
     * Constructs a new Media element with the specified parent.
     *
     * @param parent the parent object
     */
    public Media(T parent) {
        super(parent, "Media");
    }

    /**
     * Adds a new media source with the specified URL.
     *
     * @param url the URL of the media source
     * @return this media object for method chaining
     */
    public Media<T> addSource(String url) {
        MediaSource source = new MediaSource(url);
        sources.add(source);
        return this;
    }

    /**
     * Adds a new media source with the specified URL and MIME type.
     *
     * @param url the URL of the media source
     * @param mimeType the MIME type of the media source
     * @return this media object for method chaining
     */
    public Media<T> addSource(String url, String mimeType) {
        MediaSource source = new MediaSource(url, mimeType);
        sources.add(source);
        return this;
    }

    /**
     * Sets the poster image URL for the media.
     *
     * @param poster the poster image URL
     * @return this media object for method chaining
     */
    public Media<T> setPoster(String poster) {
        this.poster = poster;
        return this;
    }

    /**
     * Sets the alternative text for the media.
     *
     * @param altText the alt text
     * @return this media object for method chaining
     */
    public Media<T> setAltText(String altText) {
        this.altText = altText;
        return this;
    }

    /**
     * Adds a new caption source to the media.
     *
     * @param mimeType the MIME type of the caption source
     * @param url the URL of the caption file
     * @param label the label for the caption source
     * @return this media object for method chaining
     */
    public Media<T> addCaptionSource(String mimeType, String url, String label) {
        CaptionSource captionSource = new CaptionSource(mimeType, url, label);
        captionSources.add(captionSource);
        return this;
    }


    /**
     * Represents a single media source with a URL and optional MIME type.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public static class MediaSource {
        private String url = "";
        private String mimeType = "";

        public String getUrl() { return url; }
        public String getMimeType() { return mimeType; }

        /**
         * Protected default constructor for serialization.
         */
        protected MediaSource() { }

        /**
         * Constructs a new MediaSource with the specified URL.
         *
         * @param url the URL of the media source
         */
        protected MediaSource(String url) {
            this.url = url;
        }

        /**
         * Constructs a new MediaSource with the specified URL and MIME type.
         *
         * @param url the URL of the media source
         * @param mimeType the MIME type of the media source
         */
        protected MediaSource(String url, String mimeType) {
            this.url = url;
            this.mimeType = mimeType;
        }
    }

    /**
     * Represents a caption source for the media, such as subtitles or captions.
     */
    public static class CaptionSource {
        private String mimeType = "";
        private String url = "";
        private String label = "";

        public String getMimeType() { return mimeType; }
        public String getUrl() { return url; }
        public String getLabel() { return label; }

        /**
         * Protected default constructor for serialization.
         */
        protected CaptionSource() { }

        /**
         * Constructs a new CaptionSource with the specified MIME type, URL, and label.
         *
         * @param mimeType the MIME type of the caption source
         * @param url the URL of the caption file
         * @param label the label for the caption source
         */
        protected CaptionSource(String mimeType, String url, String label) {
            this.mimeType = mimeType;
            this.url = url;
            this.label = label;
        }
    }
}
