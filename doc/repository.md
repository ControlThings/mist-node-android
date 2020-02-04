# Information about this repository

This repository has been formed from the original android/mist-node-android repository at ControlThings Oy Ab using the following commands:

```sh
git clone foremost.controlthings.fi:/ct/mist/android/mist-node-android/ mist-node-android-apache2 -b v0.6.0-release --depth 1
echo 75420a76014ba1cf7054a712a423b35adc6223bf >.git/info/grafts
git filter-branch -- --all
git remote remove origin
#Check that there are not other remotes
git prune
git gc --aggressive
```
