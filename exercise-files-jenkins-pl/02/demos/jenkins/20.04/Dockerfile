FROM alpine:3.11 AS installer

ARG JENKINS_VERSION="2.346.1"

RUN apk add --no-cache curl
RUN apk add --no-cache --repository http://dl-cdn.alpinelinux.org/alpine/edge/community docker-cli
RUN curl -SL -o jenkins.war http://mirrors.jenkins.io/war-stable/$JENKINS_VERSION/jenkins.war

# Jenkins
FROM alpine:3.11

# jenkins deps
RUN apk add --no-cache \
    bash \
    coreutils \
    git \
    openjdk11 \
    openssh-client \
    ttf-dejavu \
    unzip 

# compose deps
RUN apk add --no-cache \
    gcc \
    libc-dev \
    libffi-dev \
    make \
    openssl-dev \
    python3-dev \
    py3-pip

#RUN pip install --upgrade pip

#RUN pip install docker-compose

RUN python3 -m venv /opt/venv
RUN . /opt/venv/bin/activate && pip3 install --upgrade pip
RUN . /opt/venv/bin/activate && pip3 install wheel
RUN . /opt/venv/bin/activate && pip3 install docker-compose

ARG JENKINS_VERSION="2.346.1"
ENV JENKINS_VERSION=${JENKINS_VERSION} \
    JENKINS_HOME="/data"

VOLUME ${JENKINS_HOME}

EXPOSE 8080
ENTRYPOINT java -Duser.home=${JENKINS_HOME} -Djenkins.install.runSetupWizard=false -jar /jenkins/jenkins.war

COPY --from=installer /usr/bin/docker /usr/bin/docker
COPY --from=installer /jenkins.war /jenkins/jenkins.war

COPY ./jenkins.install.UpgradeWizard.state ${JENKINS_HOME}/
COPY ./scripts/ ${JENKINS_HOME}/init.groovy.d/

USER root

RUN apk add bash icu-libs krb5-libs libgcc libintl libssl1.1 libstdc++ zlib wget
RUN apk add libgdiplus --repository https://dl-3.alpinelinux.org/alpine/edge/testing/

RUN mkdir -p /usr/share/dotnet \
    && ln -s /usr/share/dotnet/dotnet /usr/bin/dotnet 

RUN wget https://dot.net/v1/dotnet-install.sh
RUN chmod +x dotnet-install.sh
RUN ./dotnet-install.sh -c 3.1 --install-dir /usr/share/dotnet
RUN ./dotnet-install.sh -c 5.0 --install-dir /usr/share/dotnet
RUN ./dotnet-install.sh -c 6.0 --install-dir /usr/share/dotnet
RUN dotnet --version

# Good idea to switch back to the jenkins user.
USER jenkins