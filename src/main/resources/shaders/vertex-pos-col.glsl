#version 330

layout (location = 0) in vec3 position;

out vec4 color;

void main() {
    color = vec4(position, 1.0f);
    gl_Position = vec4(position, 1.0f);
}
