package ez.gl;

import java.nio.IntBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import static ez.gl.Context.*;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.*;
import org.lwjgl.system.MemoryStack;

public final class Program implements ObjectGL{
    
    
    public static final Program NULL_PROGRAM = new Program();
    private Program(){
        program = NULLOBJ;
        uniforms = Collections.EMPTY_MAP;
    }
    
    int program;

    private Map<String, Uniform> uniforms;

    /**
     * Создает экземпляр шейдерной программы, связывает и линкует с ней
     * переданные экземпляры шейдеров с последующей их отвязкой.
     * @param shaders список шейдеров для линковки программы.
     */
    public Program(Shader... shaders) {
        program = glCreateProgram();
        if(program == NULLOBJ)
            throw new RuntimeException("Error creating the shader program.");
        for (Shader s : shaders) glAttachShader(program, s.shader);
        glLinkProgram(program);
        if (glGetProgrami(program, GL_LINK_STATUS) == GL_FALSE)
            throw new LinkProgramException(glGetProgramInfoLog(program));
        for (Shader s : shaders) glDetachShader(program, s.shader);
        loadUniforms();
    }

    private void loadUniforms(){
        int active = glGetProgrami(program, GL_ACTIVE_UNIFORMS);
        //uniforms = new HashMap<>(active, 1.0f);
        uniforms = new HashMap<>(active/3 + active+1);
        try(MemoryStack stack = MemoryStack.stackPush()){
            IntBuffer size = stack.mallocInt(1);
            IntBuffer type = stack.mallocInt(1);
            for(int loc = 0; loc < active; loc++){
                String name = glGetActiveUniform(program, loc, size, type);
                uniforms.put(name, new Uniform(this, loc));
            }
        }
    }

    /**
     * Удаляет этот программный объект.
     */
    @Override
    public void delete() {
        if(program != NULLOBJ){
            glDeleteProgram(program);
            program = NULLOBJ;
        }
    }

    public void use() {
        ContextBindMap map;
        if((map = Context.currentContext().getBindMap()).getProgram() != this){
            glUseProgram(program);
            map.setProgram(this);
        }
    }
    
    public void check(){
        if(currentContext().getBindMap().getProgram() != this)
            throw new RuntimeException("Program must be bind.");
    }
    
    /**
     * Возвращает uniform данного программного объекта по имени.
     * @param name имя uniform
     * @return uniform данного программного объекта
     */
    public Uniform uniform(String name){
        return uniforms.get(name);
    }
    
/*
    /**
     * Связывает имя вершинного аттрибута с общим индексом аттрибута вершин в этой программе;
     * Матрица mat2xn занимет 2 аттрибута, mat3xn - 3, mat4xn - 4.
     * @param index индекс вершинного аттрибута
     * @param name имя аттрибута
     * @return this
     *//*
    public Program bindAttribLocation(int index, CharSequence name){
        glBindAttribLocation(program, index, name);
        return this;
    }

    /**
     * Назначает выходную переменную фрагментного шейдера указанному
     * цвету фрагмента.
     * @param colorNumber Номер цвета для привязки определяемой пользователем переменной
     * @param name Имя определяемой пользователем переменной, привязка которой изменяется
     * @return this
     *//*
    public Program bindFragDataLocation(int colorNumber, CharSequence name){
        glBindFragDataLocation(program, colorNumber, name);
        return this;
    }

    /**
     * Привязывает определенную пользователем переменную к номеру и индексу переменной цвета фрагментного шейдера.
     *
     * @param colorNumber Номер цвета для привязки определяемой пользователем переменной
     * @param index Индекс ввода цвета для привязки определяемой пользователем переменной
     * @param name Имя определяемой пользователем переменной, привязка которой изменяется
     * @return this
     *//*
    public Program bindFragDataLocationIndexed(int colorNumber, int index, CharSequence name){
        glBindFragDataLocationIndexed(program, colorNumber, index, name);
        return this;
    }
    */

    @Override
    public String toString() {
        return "Program-" + program;
    }

}



class LinkProgramException extends RuntimeException {
    LinkProgramException(String massage) {
        super(massage);
    }
}
