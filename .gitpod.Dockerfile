FROM gitpod/workspace-full

# Install custom tools, runtimes, etc.
# For example "bastet", a command-line tetris clone:
# RUN brew install bastet
#
# More information: https://www.gitpod.io/docs/config-docker/

# Install Graphviz
RUN sudo apt-get update && npm install -g newman

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && sdk install 21.0.2-graalce"
