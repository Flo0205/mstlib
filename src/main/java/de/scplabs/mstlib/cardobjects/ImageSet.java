package de.scplabs.mstlib.cardobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.scplabs.mstlib.options.ImageSetStyle;
import de.scplabs.mstlib.options.ImageSize;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a set of images in an adaptive card, allowing multiple images to be grouped together
 * with shared size and style options.
 *
 * @param <T> the parent type
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ImageSet<T extends CardParent<?>> extends CardSetObject<T, ImageSet<T>> {

    @JsonProperty(required = true)
    private List<Image<ImageSet<T>>> images = new ArrayList<>();
    private ImageSize imageSize = ImageSize.MEDIUM;
    private ImageSetStyle style = ImageSetStyle.DEFAULT;

    public List<Image<ImageSet<T>>> getImages() { return images; }
    public String getImageSize() { return imageSize.toString(); }
    public String getStyle() { return style.toString(); }

    /**
     * Protected default constructor for serialization.
     */
    protected ImageSet() {
        super(null, null);
    }

    /**
     * Constructs a new ImageSet with the specified parent.
     *
     * @param parent the parent object
     */
    public ImageSet(T parent) {
        super(parent, "ImageSet");
    }

    /**
     * Adds a new image to this image set.
     *
     * @param url the URL of the image
     * @return the created Image object
     */
    public Image<ImageSet<T>> addImage(String url) {
        Image<ImageSet<T>> image = new Image<>(this, url);
        images.add(image);
        return image;
    }

    /**
     * Sets the size of the images in the set.
     *
     * @param imageSize the image size
     * @return this image set for method chaining
     */
    public ImageSet<T> setImageSize(ImageSize imageSize) {
        this.imageSize = imageSize;
        return this;
    }

    /**
     * Sets the style of the image set.
     *
     * @param style the image set style
     * @return this image set for method chaining
     */
    public ImageSet<T> setStyle(ImageSetStyle style) {
        this.style = style;
        return this;
    }
}
