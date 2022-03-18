# import는 패키지나 모듈만 가져올 수 있음.

# import shapes
import shapes.area
import shapes.volume
from shapes import area

print(shapes.area.square(2))
print(shapes.volume.cube(2))
print(area.circle(4))