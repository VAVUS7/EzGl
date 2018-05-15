package ez.gl.enums;

import ez.gl.GLenum;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL32.GL_GEOMETRY_SHADER;

public enum ShaderType implements GLenum{

    VERTEX(GL_VERTEX_SHADER), 
    
    FRAGMENT(GL_FRAGMENT_SHADER), 
    
    GEOMETRY(GL_GEOMETRY_SHADER);

    private final int type;

    ShaderType(int glShaderType) {
        this.type = glShaderType;
    }

    @Override
    public int asGLenum() {return type;}
}
