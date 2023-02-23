/**
 * @author vminfo
 * @link http://vminfo.ru/javamm
 */
module javamm.vm {
    requires javamm.compiler;
    requires javamm.interpreter;
    requires javamm.library;
    requires javamm.code;

    exports info.vm.javamm.vm;
}