package ez.gl;

import ez.gl.enums.ShaderType;
import java.io.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

public abstract class Shader implements ObjectGL, Typable{

    protected int shader;
    
    protected Shader(ShaderType type, String file) throws IOException {
        shader = createShader(type, loadFromStream(new FileInputStream(file)));
    }
    
    protected Shader(ShaderType type, InputStream in) throws IOException {
        shader = createShader(type, loadFromStream(in));
    }
    
    protected static int createShader(ShaderType type, String file) throws IOException{
        try(FileInputStream st = new FileInputStream(file)){
            return createShader(type, loadFromStream(st));
        }
    }
    
    protected static int createShader(ShaderType type, InputStream in) throws IOException{
        return createShader(type, loadFromStream(in));
    }
    
    private static int createShader(ShaderType type, CharSequence strings){
        int shader = glCreateShader(type.asGLenum());
        glShaderSource(shader, strings);
        glCompileShader(shader);
        if (glGetShaderi(shader, GL_COMPILE_STATUS) == GL_FALSE){
            throw new ShaderCompileException(
                    type + ": " + glGetShaderInfoLog(shader)
            );
        }
        return shader;
    }
    
    //TODO если объективно, заменить на что-то лучше
    private static CharSequence loadFromStream(InputStream in) throws IOException{
        byte[] b = new byte[in.available()];
        in.read(b);
        return new String(b);
    }
    
    @Override
    public void delete(){
        if(shader != NULLOBJ){
            glDeleteShader(shader);
            shader = NULLOBJ;
        }
    }

    @Override
    public abstract ShaderType getType();
}

class ShaderCompileException extends RuntimeException {
    ShaderCompileException(String massage) {
        super(massage);
    }
}