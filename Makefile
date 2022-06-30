.PHONY: build

all: clean build

build:
	docker build -f docker/Dockerfile.builder -t nherbaut/dextorm-builder .
	docker run -ti --mount type=bind,source=${PWD}/build,target=/opt/dextorm-output nherbaut/dextorm-builder
	docker build -f docker/Dockerfile -t nherbaut/dextorm-gui .
	

clean:
	docker rmi nherbaut/dextorm-builder

run:
	docker run -p 8080:8080  nherbaut/dextorm-gui

push:
	docker push nherbaut/dextorm-gui
