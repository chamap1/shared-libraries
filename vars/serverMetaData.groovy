
class serverMetaData implements Serializable {
    private String DOCKER_REGISTRY = "docker-dev-local.art.local"
    
    def getDockerRegistryName() {
        return DOCKER_REGISTRY
    }

}
