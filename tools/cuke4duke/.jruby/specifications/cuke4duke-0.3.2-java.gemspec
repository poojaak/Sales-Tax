# -*- encoding: utf-8 -*-

Gem::Specification.new do |s|
  s.name = %q{cuke4duke}
  s.version = "0.3.2"
  s.platform = %q{java}

  s.required_rubygems_version = Gem::Requirement.new(">= 0") if s.respond_to? :required_rubygems_version=
  s.authors = ["Aslak Helles\303\270y"]
  s.date = %q{2010-07-15}
  s.default_executable = %q{cuke4duke}
  s.description = %q{Write Cucumber Step Definitions in Java, Scala, Groovy, Rhino Javascript, Clojure or Ioke}
  s.email = %q{cukes@googlegroups.com}
  s.executables = ["cuke4duke"]
  s.files = ["VERSION", "bin/cuke4duke", "lib/cuke4duke.jar"]
  s.homepage = %q{http://cukes.info}
  s.rdoc_options = ["--charset=UTF-8"]
  s.require_paths = ["lib"]
  s.rubygems_version = %q{1.5.1}
  s.summary = %q{JVM support for Cucumber}

  if s.respond_to? :specification_version then
    s.specification_version = 3

    if Gem::Version.new(Gem::VERSION) >= Gem::Version.new('1.2.0') then
      s.add_runtime_dependency(%q<cucumber>, ["~> 0.8.5"])
    else
      s.add_dependency(%q<cucumber>, ["~> 0.8.5"])
    end
  else
    s.add_dependency(%q<cucumber>, ["~> 0.8.5"])
  end
end
