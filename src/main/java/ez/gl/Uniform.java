package ez.gl;

import static ez.gl.Context.*;
import org.joml.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL21.*;
import static org.lwjgl.opengl.GL40.*;
import org.lwjgl.system.MemoryStack;


public class Uniform {

    Program program;
    int location;

    Uniform(Program program, int loc) {
        this.program = program;
        this.location = loc;
    }

    public void uniform(float v0) {
        currentBindMap().checkProgram(program);
        glUniform1f(location, v0);
    }
    public void uniform(float v0, float v1) {
        currentBindMap().checkProgram(program);
        glUniform2f(location, v0, v1);
    }
    public void uniform(float v0, float v1, float v2) {
        currentBindMap().checkProgram(program);
        glUniform3f(location, v0, v1, v2);
    }
    public void uniform(float v0, float v1, float v2, float v3) {
        currentBindMap().checkProgram(program);
        glUniform4f(location, v0, v1, v2, v3);
    }

    public void uniform(double v0) {
        currentBindMap().checkProgram(program);
        glUniform1d(location, v0);
    }
    public void uniform(double v0, double v1) {
        currentBindMap().checkProgram(program);
        glUniform2d(location, v0, v1);
    }
    public void uniform(double v0, double v1, double v2) {
        currentBindMap().checkProgram(program);
        glUniform3d(location, v0, v1, v2);
    }
    public void uniform(double v0, double v1, double v2, double v3) {
        currentBindMap().checkProgram(program);
        glUniform4d(location, v0, v1, v2, v3);
    }

    public void uniform(int v0) {
        currentBindMap().checkProgram(program);
        glUniform1i(location, v0);
    }
    public void uniform(int v0, int v1) {
        currentBindMap().checkProgram(program);
        glUniform2i(location, v0, v1);
    }
    public void uniform(int v0, int v1, int v2) {
        currentBindMap().checkProgram(program);
        glUniform3i(location, v0, v1, v2);
    }
    public void uniform(int v0, int v1, int v2, int v3) {
        currentBindMap().checkProgram(program);
        glUniform4i(location, v0, v1, v2, v3);
    }

    public void uniform(Vector2fc vec) {
        currentBindMap().checkProgram(program);
        glUniform2f(location, vec.x(), vec.y());
    }
    public void uniform(Vector3fc vec) {
        currentBindMap().checkProgram(program);
        glUniform3f(location, vec.x(), vec.y(), vec.z());
    }
    public void uniform(Vector4fc vec) {
        currentBindMap().checkProgram(program);
        glUniform4f(location, vec.x(), vec.y(), vec.z(), vec.w());
    }

    public void uniform(Vector2dc vec) {
        currentBindMap().checkProgram(program);
        glUniform2d(location, vec.x(), vec.y());
    }
    public void uniform(Vector3dc vec) {
        currentBindMap().checkProgram(program);
        glUniform3d(location, vec.x(), vec.y(), vec.z());
    }
    public void uniform(Vector4dc vec) {
        currentBindMap().checkProgram(program);
        glUniform4d(location, vec.x(), vec.y(), vec.z(), vec.w());
    }

    public void uniform(Vector2ic vec) {
        currentBindMap().checkProgram(program);
        glUniform2i(location, vec.x(), vec.y());
    }
    public void uniform(Vector3ic vec) {
        currentBindMap().checkProgram(program);
        glUniform3i(location, vec.x(), vec.y(), vec.z());
    }
    public void uniform(Vector4ic vec) {
        currentBindMap().checkProgram(program);
        glUniform4i(location, vec.x(), vec.y(), vec.z(), vec.w());
    }



    public void uniform(Matrix3x2fc mat) {uniform(mat, false);}
    public void uniform(Matrix3x2fc mat, boolean transpose) {
        currentBindMap().checkProgram(program);
        try(MemoryStack st = MemoryStack.stackPush()){
            glUniformMatrix3x2fv(location, transpose, mat.get(st.mallocFloat(3*2)));
        }
    }


    public void uniform(Matrix3fc mat) {uniform(mat, false);}
    public void uniform(Matrix3fc mat, boolean transpose) {
        currentBindMap().checkProgram(program);
        try(MemoryStack st = MemoryStack.stackPush()){
            glUniformMatrix3fv(location, transpose, mat.get(st.mallocFloat(3*3)));
        }
    }



    public void uniform(Matrix4x3fc mat) {uniform(mat, false);}
    public void uniform(Matrix4x3fc mat, boolean transpose) {
        currentBindMap().checkProgram(program);
        try(MemoryStack st = MemoryStack.stackPush()){
            glUniformMatrix4x3fv(location, transpose, mat.get(st.mallocFloat(4*3)));
        }
    }



    public void uniform(Matrix4fc mat) {uniform(mat, false);}
    public void uniform(Matrix4fc mat, boolean transpose) {
        currentBindMap().checkProgram(program);
        try(MemoryStack st = MemoryStack.stackPush()){
            glUniformMatrix4fv(location, transpose, mat.get(st.mallocFloat(4*4)));
        }
    }



    public void uniform(Matrix3x2dc mat) {uniform(mat, false);}
    public void uniform(Matrix3x2dc mat, boolean transpose) {
        currentBindMap().checkProgram(program);
        try(MemoryStack st = MemoryStack.stackPush()){
            glUniformMatrix3x2dv(location, transpose, mat.get(st.mallocDouble(3*2)));
        }
    }



    public void uniform(Matrix3dc mat) {uniform(mat, false);}
    public void uniform(Matrix3dc mat, boolean transpose) {
        currentBindMap().checkProgram(program);
        try(MemoryStack st = MemoryStack.stackPush()){
            glUniformMatrix3dv(location, transpose, mat.get(st.mallocDouble(3*3)));
        }
    }



    public void uniform(Matrix4x3dc mat) {uniform(mat, false);}
    public void uniform(Matrix4x3dc mat, boolean transpose) {
        currentBindMap().checkProgram(program);
        try(MemoryStack st = MemoryStack.stackPush()){
            glUniformMatrix4x3dv(location, transpose, mat.get(st.mallocDouble(4*3)));
        }
    }



    public void uniform(Matrix4dc mat) {uniform(mat, false);}
    public void uniform(Matrix4dc mat, boolean transpose) {
        currentBindMap().checkProgram(program);
        try(MemoryStack st = MemoryStack.stackPush()){
            glUniformMatrix4dv(location, transpose, mat.get(st.mallocDouble(4*4)));
        }
    }

    @Override
    public String toString() {
        return "Uniform-" + location + ": " + program;
    }


}
