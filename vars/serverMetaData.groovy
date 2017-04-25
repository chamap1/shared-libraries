
class serverMetaData implements Serializable {
    private string DOCKER_REGISTRY = "docker-dev-local.art.local"
    
    def getDockerRegistryName() {
        return DOCKER_REGISTRY
    }

}
