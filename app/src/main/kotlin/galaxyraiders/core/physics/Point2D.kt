@file:Suppress("UNUSED_PARAMETER") // <- REMOVE
package galaxyraiders.core.physics

data class Point2D(var x: Double, var y: Double) {
  operator fun plus(p: Point2D): Point2D {
    return Point2D(x + p.x, y + p.y)
  }

  operator fun plus(v: Vector2D): Point2D {
    return Point2D(x + v.dx, y + v.dy)
  }

  override fun toString(): String {
    return "Point2D(x=$x, y=$y)"
  }

  fun toVector(): Vector2D {
    return Vector2D(x, y)
  }

  fun impactVector(p: Point2D): Vector2D {
    return Vector2D(Math.abs(x - p.x), Math.abs(y - p.y))
  }

  fun impactDirection(p: Point2D): Vector2D {
    val iv = impactVector(p)
    return iv / iv.magnitude
  }

  fun contactVector(p: Point2D): Vector2D {
    val iv = impactVector(p)
    return (iv.normal)
  }

  fun contactDirection(p: Point2D): Vector2D {
    val cv = contactVector(p)
    return cv / cv.magnitude
  }

  fun distance(p: Point2D): Double {
    return Math.sqrt(Math.pow(this.x - p.x, 2.0) + Math.pow(this.y - p.y, 2.0))
  }
}
