/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ez.gl.texture;

import ez.gl.Texture;
import ez.gl.enums.TextureType;
import ez.image.Image;

/**
 *
 * @author vlad
 */
public class Texture2D extends AbstractTexture2D{

    @Override
    public TextureType getType() {return TextureType.TEXTURE_2D;}
}
