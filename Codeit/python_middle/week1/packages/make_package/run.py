# import는 패키지나 모듈만 가져올 수 있음.

import shapes.volume as vol
from shapes.area import square
from shapes import volume

print(vol.cube(3)) # shapes.volume.cube()
print(square(3))
print(volume.sphere(5))