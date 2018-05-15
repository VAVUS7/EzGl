#version 330

layout (location = 0) in vec3 pos;
layout (location = 1) in vec2 st;

out vec2 f_st;

void main() {
    f_st = st;
    gl_Position = vec4(pos, 1.0f);
}
