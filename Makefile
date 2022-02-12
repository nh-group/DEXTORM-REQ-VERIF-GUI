.DEFAULT: all

all: clean clean-docker build build-docker

build:
	mvn  package
	
build-docker: 
	docker build . -t nherbaut/dextorm-gamified-gui

clean:
	mvn clean

clean-docker: 
	docker rmi -f nherbaut/dextorm-gamified-gui

run:
	docker run -e GITHUB_OAUTH=${GITHUB_OAUTH} -e REPO_URL=${REPO_URL} -p 8080:8080 -p 8081:8081 nherbaut/dextorm-gamified-gui

push-docker:
	docker push nherbaut/dextorm-gamified-gui
