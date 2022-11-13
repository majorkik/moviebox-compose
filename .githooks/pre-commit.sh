#!C:/Program\ Files/Git/usr/bin/sh.exe

BRANCH=$(git rev-parse --abbrev-ref HEAD)
REGEX="^([a-zA-Z0-9\-]+)(\/(feature|docs|style|(bug|hot)fix))(\/[a-zA-Z0-9._-]+)$"

echo "test"

if ! [[ $BRANCH =~ $REGEX ]]; then
  echo "Your commit was rejected due to branching name"
  echo "Please rename your branch with '<username>/<type>/<branch_name>' syntax"
  echo "(avaliable types: feature|docs|style|bugfix|hotfix)"
  exit 1
fi
