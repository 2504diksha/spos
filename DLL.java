ArithmeticOperations.c

#include &lt;jni.h&gt;
#include &quot;ArithmeticOperations.h&quot;

JNIEXPORT jint JNICALL Java_ArithmeticOperations_add(JNIEnv *env, jobject obj, jint
a, jint b) {
return a + b;
}

JNIEXPORT jint JNICALL Java_ArithmeticOperations_subtract(JNIEnv *env, jobject obj,
jint a, jint b) {
return a - b;
}

JNIEXPORT jint JNICALL Java_ArithmeticOperations_multiply(JNIEnv *env, jobject obj,
jint a, jint b) {
return a * b;
}

JNIEXPORT jint JNICALL Java_ArithmeticOperations_divide(JNIEnv *env, jobject obj,
jint a, jint b) {
if (b == 0) {
return 0; // Handle division by zero
}
return a / b;
}

ArithmeticOperations.java

public class ArithmeticOperations
{
public native int add(int a, int b);

public native int subtract(int a, int b);
public native int multiply(int a, int b);
public native int divide(int a, int b);

static
{
System.loadLibrary(&quot;ArithmeticOperations&quot;);
}

public static void main(String[] args)
{
ArithmeticOperations ops = new ArithmeticOperations();
int a = 10, b = 5;
System.out.println(&quot;Addition: &quot; + ops.add(a, b));
System.out.println(&quot;Subtraction: &quot; + ops.subtract(a, b));
System.out.println(&quot;Multiplication: &quot; + ops.multiply(a, b));
System.out.println(&quot;Division: &quot; + ops.divide(a, b));
}
}
