// def call(String project,String ImageTag, String hubUser){
    
//     sh """
//      docker rmi ${hubUser}/${project}:${ImageTag}
//      docker rmi ${hubUser}/${project} ${hubUser}/${project}:latest
//     """
// }

def call(String project, String ImageTag, String hubUser) {
    sh """
        if docker images -q ${hubUser}/${project}:${ImageTag} >/dev/null; then
            docker rmi ${hubUser}/${project}:${ImageTag}
        fi

        if docker images -q ${hubUser}/${project} >/dev/null; then
            docker rmi ${hubUser}/${project}
        fi

        if docker images -q ${hubUser}/${project}:latest >/dev/null; then
            docker rmi ${hubUser}/${project}:latest
        fi
    """
}
