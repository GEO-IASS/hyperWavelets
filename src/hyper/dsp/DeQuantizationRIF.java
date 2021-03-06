package hyper.dsp;

import java.awt.*;
import java.awt.image.*;
import java.awt.image.renderable.*;
import javax.media.jai.*;
import java.util.Vector;

/**
  * Class implementing the RIF interface for the Dequantization operator.
  * An instance of this class should be registered with the OperationRegistry
  * with operation name "Dequantization" and product name "ccd-hyper".
  */
public class DeQuantizationRIF implements RenderedImageFactory {
   public DeQuantizationRIF() {}
   
   public RenderedImage create(ParameterBlock paramBlock,
                               RenderingHints renderHints) {
      RenderedImage source = paramBlock.getRenderedSource(0);
      
      ImageLayout layout = renderHints == null ? null : 
                  (ImageLayout)renderHints.get(JAI.KEY_IMAGE_LAYOUT);
      
      String algorism = (String)paramBlock.getObjectParameter(0);
      int level = paramBlock.getIntParameter(1);
      Vector[] coefs = (Vector[])paramBlock.getObjectParameter(2);
	  
      return new DeQuantizationOpImage(source, layout, renderHints,
             algorism, level, coefs);
   }

}
