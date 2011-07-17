Given /there are (\d+) vendors/i do |n|
 Vendor.transaction do
 Vendor.destroy_all 
n.to_i.times do |n|
 Factory.create(:vendor, :business_name => "Vendor #{n}")
 end 
end
 end
