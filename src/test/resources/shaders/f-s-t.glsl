#version 330 core

in vec2 f_st;

out vec4 f_color;

uniform sampler2D t_unit0;

void main() {
    f_color = texture2D(t_unit0, f_st);
}
