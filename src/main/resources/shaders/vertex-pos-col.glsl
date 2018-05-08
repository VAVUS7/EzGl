#version 330

layout (location = 0) in vec3 position;

out vec4 color;

void main() {
color = position;
    gl_Position = position;
}
