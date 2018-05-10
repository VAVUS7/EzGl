package ez.gl;

import ez.gl.enums.ShaderType;
import java.io.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

public final class Shader implements GLObject{

    int shader;
    
    public Shader(ShaderType type, String name) throws IOException {
        shader = createShader(type, loadFromStream(new FileInputStream(name)));
    }
    
    public Shader(ShaderType type, InputStream in) throws IOException {
        shader = createShader(type, loadFromStream(in));
    }
    
    private static int createShader(ShaderType type, CharSequence strings){
        int shader = glCreateShader(type.type);
        glShaderSource(shader, strings);
        glCompileShader(shader);
        if (glGetShaderi(shader, GL_COMPILE_STATUS) == GL_FALSE){
            throw new ShaderCompileException(
                    type + ": " + System.lineSeparator() + glGetShaderInfoLog(shader)
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
        if(isExist()){
            glDeleteShader(shader);
            shader = NULLOBJ;
        }
    }

    @Override
    public boolean isExist() {return shader != NULLOBJ;}    
}

class ShaderCompileException extends RuntimeException {
    
    
    ShaderCompileException(String massage) {
        super(massage);
    }
}