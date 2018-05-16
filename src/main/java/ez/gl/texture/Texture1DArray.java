/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez.gl.texture;

import static ez.gl.Context.currentBindMap;
import static ez.gl.Context.currentContext;
import ez.gl.Texture;
import ez.gl.enums.MagFilter;
import ez.gl.enums.MinFilter;
import ez.gl.enums.TextureType;
import ez.gl.enums.WrapMode;
import ez.image.Image;

/**
 *
 * @author vlad
 */
public class Texture1DArray extends Texture{
    
        public final Texture1DArray texImage2D(Image im){
        currentBindMap().checkTexture(this);
        texImage2D(getType(), im);
        return this;
    }
    
    public final Texture1DArray generateMipmap(){
        currentBindMap().checkTexture(this);
        generateMipmap(getType());
        return this;
    }
    
    public final Texture1DArray setFilters(MinFilter min, MagFilter mag){
        currentBindMap().checkTexture(this);
        Texture.setFilters(getType(), min, mag);
        return this;
    }
    
    public final Texture1DArray setWrapping(WrapMode s, WrapMode t){
        currentBindMap().checkTexture(this);
        setWrapping(getType(), s, t);
        return this;
    }
    
    @Override
    public TextureType getType() {return TextureType.TEXTURE_1D_ARRAY;}
    
}
